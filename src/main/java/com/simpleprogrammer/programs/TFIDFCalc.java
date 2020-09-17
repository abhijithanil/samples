package com.simpleprogrammer.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// cerner_2^5_2020

public class TFIDFCalc {

  public double tf(final String term, final List<String> terms) {
    final AtomicReference<Double> count = new AtomicReference<>((double) 0);
    terms.forEach(
        e -> {
          if (term.equalsIgnoreCase(e)) {
            count.getAndSet(new Double((double) (count.get() + 1)));
          }
        });
    return count.get();
  }

  public double idf(final List<List<String>> doc, final String term) {
    final AtomicReference<Double> n = new AtomicReference<>((double) 0);
    doc.forEach(
        terms -> terms.forEach(
            e -> {
              if (term.equalsIgnoreCase(e)) {
                n.getAndSet(n.get() + 1);
              }
            }));
    return Math.log10(doc.size() / n.get());
  }

  public double tfidf(final List<List<String>> doc, final List<String> terms, final String term) {
    return tf(term, terms) * idf(doc, term);
  }

  public static void main(String[] args) {

    final TFIDFCalc tfidfCalc = new TFIDFCalc();

    final String s0 = "India india is my my country";
    final String s1 = "i love love india";
    final String s2 = "we we we love love our our country india";
    final List<String> s0List = new ArrayList<>(Arrays.asList(s0.split(" ")));
    final List<String> s1List = new ArrayList<>(Arrays.asList(s1.split(" ")));
    final List<String> s2List = new ArrayList<>(Arrays.asList(s2.split(" ")));

    final List<List<String>> doc = Arrays.asList(s0List, s1List, s2List);

    doc.forEach(
        terms -> terms.forEach(
            unqw -> System.out.println("tfidf of word '" + unqw + "' is:" + tfidfCalc.tfidf(doc, terms, unqw))));
  }
}
