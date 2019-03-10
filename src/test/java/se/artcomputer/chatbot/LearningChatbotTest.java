package se.artcomputer.chatbot;

import org.junit.Before;
import org.junit.Test;

public class LearningChatbotTest {

    private ChatbotBrain chatbotBrain;

    @Before
    public void setUp() {
        chatbotBrain = new ChatbotBrain();
    }

    @Test
    public void script1() {
        saynolisten("Hello, Chatbot!");
        saynolisten("How are you today?");
        saynolisten("What kind of things do you want to talk about?");
        saynolisten("Oh, that's strange.");
        System.out.println(chatbotBrain.toString());
    }

    private void saynolisten(String said) {
        System.out.println(said);
        String answer = say(said);
        System.out.println("Answer: '" + answer + "'");
    }

    private String say(String said) {
        chatbotBrain.decay();
        chatbotBrain.digestSentence(said);
        return chatbotBrain.buildSentence();
    }
}