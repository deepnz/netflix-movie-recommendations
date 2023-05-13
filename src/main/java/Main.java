package edu.stanford.nlp.examples;

import edu.stanford.nlp.io.*;
import edu.stanford.nlp.pipeline.*;

import java.util.*;


public class PipelineExample {

    public static String text = "Marie was born in Paris.";

    public static void main(String[] args) {
        // set up pipeline properties
        Properties props = new Properties();
        // set the list of annotators to run
        props.setProperty("annotators", "tokenize,pos,lemma,ner,depparse");
        // build pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // create a document object
        CoreDocument document = pipeline.processToCoreDocument(text);
    }

}