
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Test_ListEmotions {


    // Sample test case for the functionality "predominantEmotion"
    // Case - empty list
    // Expected - no change
    @Test
    public void Test_PredominantJoy_predominantEmotion(){
        System.out.println("Test .... Test_PredominantJoy_predominantEmotion ... ");
        List<Emotion> testLstEmotions = new ArrayList<Emotion>();
        List lEmotions = new ArrayList<Emotion>();
        ListEmotions le = new ListEmotions(lEmotions);

        List<Emotion> lstPE = le.predominantEmotion();
        //System.out.println("Number of Predominant Emotions="+lstPE.size());
        assertEquals(lstPE.size(), 0);
    }

    // Case - 1 element list
    // Expected - no change
    @Test
    public void Test_OneElement_predominantEmotion(){
        System.out.println("Test .... Test_OneElement_predominantEmotion ... ");
        List<Emotion> list = new ArrayList<>();
        Emotion sad = new Emotion("Sadness", EmotionType.Sadness);
        list.add(sad);
        ListEmotions emotions = new ListEmotions(list);

        assertEquals(emotions.predominantEmotion().get(0), sad);
        assertEquals(emotions.predominantEmotion().size(), 1);
    }

    // Case - same element list
    // Expected - no change
    @Test
    public void Test_SameElement_predominantEmotion(){
        System.out.println("Test .... Test_SameElement_predominantEmotion ... ");
        List<Emotion> list = new ArrayList<>();
        Emotion sad = new Emotion("Sadness", EmotionType.Sadness);
        list.add(sad);
        list.add(sad);
        list.add(sad);
        ListEmotions emotions = new ListEmotions(list);

        List<Emotion> result = emotions.predominantEmotion();
        assertEquals(result.get(0), sad);
        assertEquals(result.get(2), sad);
        assertEquals(result.size(), 3);
    }

    // Case - different element frequency list
    // Expected - the one that occurs most is at the top of the list while the one that occurs least is at the bottom
    @Test
    public void Test_DiffElements_predominantEmotion(){
        System.out.println("Test .... Test_DiffElements_predominantEmotion ... ");
        List<Emotion> list = new ArrayList<>();
        Emotion sad = new Emotion("Sadness", EmotionType.Sadness);
        Emotion disgusted = new Emotion("Sadness", EmotionType.Disgust);
        Emotion joy = new Emotion("Sadness", EmotionType.Joy);
        list.add(sad);
        list.add(sad);
        list.add(sad);
        list.add(disgusted);
        list.add(joy);
        list.add(disgusted);
        ListEmotions emotions = new ListEmotions(list);

        List<Emotion> result = emotions.predominantEmotion();
        assertEquals(result.get(0), sad);
        assertEquals(result.get(result.size() - 1), joy);
        assertEquals(result.get(result.size() - 2), disgusted);
    }

    // Case - at least 2 elements have the same frequency and there exist other elements
    // Expected - will be displayed in the order they were added
    @Test
    public void Test_2Same_predominantEmotion(){
        System.out.println("Test .... Test_2Same_predominantEmotion ... ");
        List<Emotion> list = new ArrayList<>();
        Emotion sad = new Emotion("Sadness", EmotionType.Sadness);
        Emotion disgusted = new Emotion("Sadness", EmotionType.Disgust);
        Emotion joy = new Emotion("Sadness", EmotionType.Joy);
        Emotion anger = new Emotion("Sadness", EmotionType.Anger);
        list.add(sad);
        list.add(sad);
        list.add(joy);
        list.add(disgusted);
        list.add(anger);
        list.add(anger);
        ListEmotions emotions = new ListEmotions(list);

        List<Emotion> result = emotions.predominantEmotion();
        assertEquals(emotions.predominantEmotion().get(0), sad);
        assertEquals(emotions.predominantEmotion().get(1), sad);
        assertEquals(emotions.predominantEmotion().get(2), anger);
        assertEquals(emotions.predominantEmotion().get(3), anger);
    }

    // Provided test cases for "eliminateAllProvidedEmotion"
    @Test
    public void Test_EliminateOne_eliminateAllProvidedEmotion(){
        System.out.println("Test .... Test_EliminateOne_eliminateAllProvidedEmotion ... ");
        List<Emotion> testLstEmotions = new ArrayList<Emotion>();
        List lEmotions = new ArrayList<Emotion>();
        Emotion eA = new Emotion("Anger", EmotionType.Anger);
        lEmotions.add(eA);
        Emotion eS = new Emotion("Sadness", EmotionType.Sadness);
        lEmotions.add(eS);
        Emotion eJ = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ);
        Emotion eD = new Emotion("Disgust", EmotionType.Disgust);
        lEmotions.add(eD);
        Emotion eF = new Emotion("Fear", EmotionType.Fear);
        lEmotions.add(eF);

        ListEmotions le = new ListEmotions(lEmotions);
        //System.out.println("Number of  Emotions="+le.getNumberOfEmotions());
        le.eliminateAllProvidedEmotion(EmotionType.Joy);
        assertEquals(le.getNumberOfEmotions(), 4);
    }
    @Test
    public void Test_EliminateAll_eliminateAllProvidedEmotion(){
        System.out.println("Test .... Test_EliminateAll_eliminateAllProvidedEmotion ... ");
        List<Emotion> testLstEmotions = new ArrayList<Emotion>();
        List lEmotions = new ArrayList<Emotion>();
        Emotion eJ = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ);
        Emotion eA = new Emotion("Anger", EmotionType.Anger);
        lEmotions.add(eA);
        Emotion eJ2 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ2);
        Emotion eS = new Emotion("Sadness", EmotionType.Sadness);
        lEmotions.add(eS);
        Emotion eJ3 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ3);
        Emotion eD = new Emotion("Disgust", EmotionType.Disgust);
        lEmotions.add(eD);
        Emotion eF = new Emotion("Fear", EmotionType.Fear);
        lEmotions.add(eF);
        Emotion eJ4 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ4);

        ListEmotions le = new ListEmotions(lEmotions);
        //System.out.println("Number of  Emotions="+le.getNumberOfEmotions());
        le.eliminateAllProvidedEmotion(EmotionType.Joy);
        //System.out.println("Number of Emotions after elimination="+le.getNumberOfEmotions());
        assertEquals(le.getNumberOfEmotions(), 4);
    }
    @Test
    public void Test_EliminateAllElements_eliminateAllProvidedEmotion(){
        System.out.println("Test .... Test_EliminateAllElements_eliminateAllProvidedEmotion ... ");
        List<Emotion> testLstEmotions = new ArrayList<Emotion>();
        List<Emotion> lEmotions = new ArrayList<Emotion>();
        Emotion eJ = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ);
        Emotion eJ2 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ2);
        Emotion eJ3 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ3);
        Emotion eJ4 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ4);

        ListEmotions le = new ListEmotions(lEmotions);
      //  System.out.println("Number of  Emotions="+le.getNumberOfEmotions());
        le.eliminateAllProvidedEmotion(EmotionType.Joy);
        assertEquals(le.getNumberOfEmotions(), 0);
    }

    @Test
    public void Test_EliminateZeroElements_eliminateAllProvidedEmotion(){
        System.out.println("Test .... Test_EliminateZeroElements_eliminateAllProvidedEmotion ... ");
        List<Emotion> testLstEmotions = new ArrayList<Emotion>();
        List<Emotion> lEmotions = new ArrayList<Emotion>();
        Emotion eA = new Emotion("Anger", EmotionType.Anger);
        lEmotions.add(eA);
        Emotion eS = new Emotion("Sadness", EmotionType.Sadness);
        lEmotions.add(eS);
        Emotion eD = new Emotion("Disgust", EmotionType.Disgust);
        lEmotions.add(eD);
        Emotion eF = new Emotion("Fear", EmotionType.Fear);
        lEmotions.add(eF);

        ListEmotions le = new ListEmotions(lEmotions);
        //System.out.println("Number of  Emotions="+le.getNumberOfEmotions());
        le.eliminateAllProvidedEmotion(EmotionType.Joy);
        assertEquals(le.getNumberOfEmotions(), 4);
    }
    @Test
    public void Test_EliminateFirstLast_eliminateAllProvidedEmotion(){
        System.out.println("Test .... Test_EliminateFirstLast_eliminateAllProvidedEmotion ... ");
        List<Emotion> testLstEmotions = new ArrayList<Emotion>();
        List<Emotion> lEmotions = new ArrayList<Emotion>();
        Emotion eJ = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ);
        Emotion eA = new Emotion("Anger", EmotionType.Anger);
        lEmotions.add(eA);
        Emotion eS = new Emotion("Sadness", EmotionType.Sadness);
        lEmotions.add(eS);
        Emotion eD = new Emotion("Disgust", EmotionType.Disgust);
        lEmotions.add(eD);
        Emotion eF = new Emotion("Fear", EmotionType.Fear);
        lEmotions.add(eF);
        Emotion eJ4 = new Emotion("Joy", EmotionType.Joy);
        lEmotions.add(eJ4);

        ListEmotions le = new ListEmotions(lEmotions);
        //System.out.println("Number of  Emotions="+le.getNumberOfEmotions());
        le.eliminateAllProvidedEmotion(EmotionType.Joy);
        assertEquals(le.getNumberOfEmotions(), 4);
    }
}
