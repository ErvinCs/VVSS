import java.util.ArrayList;
import java.util.List;

public class AMainClass {
    public static void main(String[] args) {
        List<Emotion> arrayList = new ArrayList<>();
        arrayList.add(new Emotion("This is a string", EmotionType.Joy));
        arrayList.add(new Emotion("This is a string", EmotionType.Joy));
        arrayList.add(new Emotion("This is a string", EmotionType.Anger));
        arrayList.add(new Emotion("Not a duplicate", EmotionType.Joy));
        arrayList.add(new Emotion("Disgust", EmotionType.Disgust));
        ListEmotions emotionList = new ListEmotions(arrayList);

        assert emotionList.howGivenManyEmotionTypeInListEmotions(EmotionType.Joy) == 3;
        assert emotionList.howGivenManyEmotionTypeInListEmotions(EmotionType.Sadness) == 0;
        assert emotionList.howGivenManyEmotionTypeInListEmotions(EmotionType.Disgust) == 1;
    }
}
