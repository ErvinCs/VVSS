import java.lang.reflect.Array;
import java.util.*;

public class ListEmotions {

    private List<Emotion> lstEmotions;

    public ListEmotions(List<Emotion> newLstEmotions){
        this.lstEmotions = newLstEmotions;
    }

    public int getNumberOfEmotions(){
        return lstEmotions.size();
    }

    // Task A_1
    // return the number of emotion of the given EmotionType et
    // Remark: No test cases are going to be created.
    public int howGivenManyEmotionTypeInListEmotions(EmotionType et){
        int nJE=0;

        for(Emotion emotion : this.lstEmotions) {
            if (emotion.getEmotionType().equals(et))
                nJE++;
        }

        return nJE;
    }

    // Task A_2
    // return the list of predominant emotions
    // Remark: Create a set of test cases to assess the correctness of your code.
    //         Create a class to test this method, several test cases are needed.
    //         One sample test case is provided in cladd Test_ListEmotions.
    public List<Emotion> predominantEmotion(){
        // I assume "the list of predominant emotionS" refers to a List<Emotion>
        //  sorted by how often an EmotionType appears in the list;
        //  if an emotion occurs 0 times it will not be added to the list
        // If that is the case I believe that returning List<EmotionType> would make more sense
        // As of now i have provided an implementation that uses the equals in Emotion.class
        //  (which compares the emotion types) and a Comparator to sort the list by how often an emotion occurs

        List<Emotion> lstEPredominant = new ArrayList<>(this.lstEmotions);

        Collections.sort(lstEPredominant, new Comparator<Emotion>() {
            @Override
            public int compare(Emotion o1, Emotion o2) {
                return Collections.frequency(lstEPredominant, o2) - Collections.frequency(lstEPredominant, o1);
            }
        });

//        List<EmotionType> types = new ArrayList<>(Arrays.asList(EmotionType.values()));
//        List<Integer> occurence = new ArrayList<>();
//        for(int i = 0; i < EmotionType.values().length; i++)
//            occurence.add(0);
//        this.lstEmotions.forEach(emotion -> occurence.set(emotion.getEmotionType().ordinal(), occurence.get(emotion.getEmotionType().ordinal()) + 1));
//
//        for(int i = 0; i < occurence.size(); i++) {
//        }

        return lstEPredominant;
    }

    // Task A_3
    // Eliminate the emotions that are of given type EmotionType et
    // Remark: A set of test cases to assess the correctness of your code is provided.
    //         A class to test this method was created, several test cases were added.
    //         Use the test cases to check for your code.
    public void eliminateAllProvidedEmotion(EmotionType et){
        this.lstEmotions.removeIf(emotion -> emotion.getEmotionType().equals(et));  //.name
//        Iterator<Emotion> emotionIterator = this.lstEmotions.iterator();
//        while(emotionIterator.hasNext()){
//            Emotion current = emotionIterator.next();
//            if (current.getEmotionType().name().equals(et.name()))
//                this.lstEmotions.remove(current);
//        }
    }
}
