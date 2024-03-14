import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class SoundBoard {
    private Clip clip;

    // Sound plays when a Pokemon is added
    void play() {
        playSound("src/added.wav");
    }

    // Sound plays when you exit the Program or error
    void ending() {
        playSound("src/ending.wav");
    }

    //Sound plays when you are searching for a Pokemon and its found
    void searching () {
        playSound("src/searching.wav");
    }

    // Function to make easier to play different sounds from different files
    private void playSound(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());

            // Get the audio format from the audio stream
            AudioFormat format = audioIn.getFormat();

            // Specify a supported audio format
            AudioFormat supportedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    44100.0f,
                    16,
                    1,
                    2,
                    44100.0f,
                    false
            );

            // Convert the audio format if necessary
            if (!format.matches(supportedFormat)) {
                audioIn = AudioSystem.getAudioInputStream(supportedFormat, audioIn);
            }

            // Open a new clip with the specified format
            clip = AudioSystem.getClip();
            clip.open(audioIn);

            // Add a listener to know when the clip has finished playing
            CountDownLatch latch = new CountDownLatch(1);
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    latch.countDown();
                }
            });

            // Start playing the clip
            clip.start();

            // Wait for the clip to finish
            latch.await();

            // Close the clip after it has finished
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}