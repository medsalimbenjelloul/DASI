package core;

import java.io.File;
import java.io.IOException;
import gate.Corpus;
import gate.CorpusController;
import gate.Document;
import gate.Factory;
import gate.Gate;
import gate.LanguageAnalyser;
import gate.ProcessingResource;
import gate.creole.SerialAnalyserController;
import gate.util.GateException;
import gate.util.persistence.PersistenceManager;

public class TextProcessing {
	
	public TextProcessing(String path) {
		try {
			GateInit(path);
			AnnieInit();
		} catch (GateException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void GateInit(String path) throws GateException, IOException {
		Gate.setGateHome(new File(path));
		Gate.init();
	}

	public void AnnieInit() throws GateException, IOException {
		CorpusController annieController;
		File pluginsHome = Gate.getPluginsHome();
		File anniePlugin = new File(pluginsHome, "lib\\ANNIE");
		File annieGapp = new File(anniePlugin, "ANNIE_with_defaults.gapp");
		annieController = (CorpusController) PersistenceManager.loadObjectFromFile(annieGapp);

		Corpus corpus1 = Factory.newCorpus("corpus");
		annieController.setCorpus(corpus1);
		annieController.execute();
	}

	public void JadeProcess(Document doc, String JapeDictonaryPath) throws GateException, IOException {

		gate.Corpus corpus = (Corpus) Factory.createResource("gate.corpora.CorpusImpl");

		corpus.add(doc);
		LanguageAnalyser jape = (LanguageAnalyser) Factory.createResource("gate.creole.Transducer",
				gate.Utils.featureMap("grammarURL", JapeDictonaryPath, "encoding", "UTF-8"));

		jape.setCorpus(corpus);
		jape.setDocument(doc);
		jape.execute();

		ProcessingResource token = (ProcessingResource) Factory.createResource("gate.creole.tokeniser.DefaultTokeniser",
				Factory.newFeatureMap());
		SerialAnalyserController pipeline = (SerialAnalyserController) Factory.createResource(
				"gate.creole.SerialAnalyserController", Factory.newFeatureMap(), Factory.newFeatureMap(), "ANNIE");

		LanguageAnalyser gazetter = (LanguageAnalyser) Factory.createResource("gate.creole.gazetteer.DefaultGazetteer");
		LanguageAnalyser splitter = (LanguageAnalyser) Factory.createResource("gate.creole.splitter.SentenceSplitter");
		pipeline.setCorpus(corpus);
		pipeline.add(token);
		pipeline.add(gazetter);
		pipeline.add(splitter);
		pipeline.add((ProcessingResource) jape.init());

		pipeline.execute();
	}

}
