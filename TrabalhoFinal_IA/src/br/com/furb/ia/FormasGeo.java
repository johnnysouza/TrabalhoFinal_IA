/*
 * Encog(tm) Java Examples v3.3
 * http://www.heatonresearch.com/encog/
 * https://github.com/encog/encog-java-examples
 *
 * Copyright 2008-2014 Heaton Research, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For more information on Heaton Research copyrights, licenses
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */
package br.com.furb.ia;

import org.encog.Encog;
import org.encog.ml.data.MLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.util.csv.CSVFormat;
import org.encog.util.simple.EncogUtility;
import org.encog.util.simple.TrainingSetUtil;

/**
 * Formato das colunas do arquivo
 * Área do objeto, Área da boundbox, Altura e Largura
 */
public class FormasGeo {

	private static String ARQUIVO = "src\\br\\com\\furb\\ia\\formasGeo.csv";

	public static void main(final String args[]) {
		final MLDataSet trainingSet = TrainingSetUtil.loadCSVTOMemory(
				CSVFormat.ENGLISH, ARQUIVO, false, 4, 1);
		final BasicNetwork network = EncogUtility.simpleFeedForward(4, 16,
				0, 1, true);

		System.out.println();
		System.out.println("Training Network");
		EncogUtility.trainToError(network, trainingSet, 0.004);

		System.out.println();
		System.out.println("Evaluating Network");
		EncogUtility.evaluate(network, trainingSet);
		Encog.getInstance().shutdown();
	}
}
