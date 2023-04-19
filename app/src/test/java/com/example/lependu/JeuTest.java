package com.example.lependu;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class JeuTest{
    public JeuTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    // tests Constructeur
    @Ignore
    @Test
    public void testJeu1() throws IllegalArgumentException {
        System.out.println("Premier test du constructeur avec une liste non vide: ");
        ArrayList<String> listeMots = new ArrayList<>();
        listeMots.add("bourgeoisie");
        listeMots.add("intergouvernementalisationn");
        listeMots.add("canada");
        listeMots.add("allemagne");
        Jeu jeu1 = new Jeu(listeMots);
        assertEquals(4, listeMots.size());
        System.out.println(jeu1.getMotADeviner());

    }

    @Ignore
    @Test
    public void testJeu2() throws IllegalArgumentException {
        System.out.println("Deuxième test du constructeur et du getNBErreurs: ");
        ArrayList<String> listeMots1 = new ArrayList<>();
        listeMots1.add("python");
        listeMots1.add("pava");
        Jeu jeu2 = new Jeu(listeMots1);
        assertEquals(0, jeu2.getNbErreurs());

    }

    @Ignore
    @Test
    public void testJeu3() throws IllegalArgumentException {
        System.out.println("Troisième test du constructeur et du getPointage: ");
        ArrayList<String> listeMots2 = new ArrayList<>();
        listeMots2.add("informatique");
        listeMots2.add("médecine");
        Jeu jeu3 = new Jeu(listeMots2);
        assertEquals(0, jeu3.getPointage());

    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testJeu4() throws IllegalArgumentException {
        System.out.println("Quatrième et dernier test du constructeur: (Avec exception)");
        ArrayList<String> listeMots3 = new ArrayList<>();
        Jeu jeu4 = new Jeu(listeMots3);
        assertEquals(0, listeMots3.size());

    }

    // tests de la méthode essayerUneLettre
    @Ignore
    @Test
    public void TestEssayerUneLettre1() throws IllegalArgumentException {
        System.out.println("Premier test de la méthode essayerUneLettre() (cas limite ");
        ArrayList<String> listeMots4 = new ArrayList<>();
        listeMots4.add("ordinateur");
        Jeu jeu5 = new Jeu(listeMots4);
        ArrayList<Integer> listindex1 = new ArrayList<>();
        listindex1 = jeu5.essayerUneLettre('D');

        //assertEquals("ordinateur", jeu5.getMotADeviner());
        assertEquals(1, listindex1.size());
        assertEquals(0, jeu5.getNbErreurs());
        assertEquals(1, jeu5.getPointage());
        System.out.println(listindex1);
        System.out.println("Le nombre d'erreurs est :"+jeu5.getNbErreurs());

    }

    //@Ignore
    @Test
    public void TestEssayerUneLettre2() throws IllegalArgumentException {
        System.out.println("Deuxième test de la méthode essayerUneLettre() (comportement normal)");
        ArrayList<String> listeMost5 = new ArrayList<>();
        listeMost5.add("effectif");
        Jeu jeu6 = new Jeu(listeMost5);
        ArrayList<Integer> listIndex2 = new ArrayList<>();
        listIndex2 = jeu6.essayerUneLettre('F');
        assertEquals(3,listIndex2.size());
        assertEquals(3, jeu6.getPointage());
        assertEquals(0, jeu6.getNbErreurs());
        System.out.println(listIndex2);

    }

    @Ignore
    @Test
    public void TestEssayerUneLettre3() throws IllegalArgumentException {
        System.out.println("Troisième test de la méthode essayerUneLettre() (cas d'erreur)");
        ArrayList<String> listeMost6 = new ArrayList<>();
        listeMost6.add("effectif");
        Jeu jeu6 = new Jeu(listeMost6);
        ArrayList<Integer> listIndex3 = new ArrayList<>();
        listIndex3 = jeu6.essayerUneLettre('A');
        assertEquals(3,listIndex3.size());


    }

    //test de la méthode estReussi
    @Ignore
    @Test
    public void TestEstReussi1() throws IllegalArgumentException {
        System.out.println("Premier test de la méthode TestEstReussi (Cas limite)");
        ArrayList<String> listMots7 = new ArrayList<>();
        listMots7.add("est");
        Jeu jeu7 =  new Jeu(listMots7);
        jeu7.essayerUneLettre('E');
        jeu7.essayerUneLettre('S');
        jeu7.essayerUneLettre('T');
        assertEquals(true, jeu7.estReussi("est"));
    }

    @Ignore
    @Test
    public void TestEstReussi2() throws IllegalArgumentException {
        System.out.println("Deuxième test de la méthode TestEstReussi (comportement normal)");
        ArrayList<String> listMots7 = new ArrayList<>();
        listMots7.add("test");
        Jeu jeu7 =  new Jeu(listMots7);
        jeu7.essayerUneLettre('E');
        jeu7.essayerUneLettre('S');
        jeu7.essayerUneLettre('T');
        assertEquals(true, jeu7.estReussi("test"));
    }

    @Test
    public void TestEstReussi3() throws IllegalArgumentException {
        System.out.println("Troisième test de la méthode TestEstReussi (cas d'erreur)");
        ArrayList<String> listMots7 = new ArrayList<>();
        listMots7.add("est");
        Jeu jeu7 =  new Jeu(listMots7);
        jeu7.essayerUneLettre('E');
        jeu7.essayerUneLettre('S');
        jeu7.essayerUneLettre('U');
        assertEquals(true, jeu7.estReussi("est"));
    }
    
}