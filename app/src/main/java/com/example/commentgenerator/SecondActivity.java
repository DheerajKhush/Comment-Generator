package com.example.commentgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView txtView;
    Button copyButton;

    private String[] string;

    {
        string = new String[]{"Whatever is good for your soul, do that",
                "Even the stars were jealous of the sparkle in her eyes",
                "Stress less and enjoy the best",
                "Get out there and live a little",
                "I’m not high maintenance, you’re just low effort",
                "I’m not gonna sugar coat the truth, I’m not Willy Wonka",
                "Life is better when you’re laughing",
                "Look for the magic in every moment",
                "Vodka may not be the answer but it’s worth a shot",
                "A sass a day keeps the basics away",
                "Me, myself and I",
                "Just me",
                "But first, let me take a selfie",
                "Typical me",
                "Selfie Sunday",
                "I was born to shine",
                "Me doing me",
                "I don’t always take a selfie, but when I do…",
                "What do you think of this look?",
                "I woke up like this",
                "Couldn’t be happier 🙂",
                "You can regret a lot of things but you’ll never regret being kind",
                "Do whatever makes you happiest",
                "“Having the dream is easy, making it come true is hard” – Serena Williams",
                "Decluttering my life like Marie Kondo",
                "If I were rich, I’d pull a Netflix and spend $100 million on my Friends",
                "In 2019, I want to be as Insta famous as an egg and as ageless as Paul Rudd",
                "Can’t hear, can’t speak, can’t see.",
                "“Be heroes of your own stories” – Constance Wu",
                "“Hella fine and it works every time” – Ariana Grande",
                "My life is as crooked as Rami Malek’s bowtie",
                "We did it!",
                "Work hard then work harder",
                "Hustlin’",
                "When daydreams become reality",
                "Say yes, take risks, and live life on your own terms",
                "The impossible is now possible",
                "Perseverance pays… a lot!",
                "It wasn’t always easy but it’s worth it",
                "Pursue your passion and you’ll never work a day in your life",
                "Entrepreneur life",
                "Just the two of us",
                "He’s my best friend",
                "He’s my King, I’m his Queen",
                "Sometimes relationships end so love stories can begin",
                "We are totally #couplegoals",
                "My world, my heart, my everything",
                "Bae",
                "My one and only",
                "My love",
                "You’re my 1 in 7 billion",
                "Friends are like stars, constantly coming and going, but the ones that stay burn as bright as the sun",
                "A good friend might know your wild stories but your best friend was right there with you",
                "I would never let my best friend do anything stupid…alone",
                "bff ❤️",
                "Laughing at random things. Partying ‘til the sunrise. There’s no one else I’d want by my side. Love ya!",
                "Hold onto your best friend because you’ll never find someone like them again",
                "Back in the old days my best friend why quiet and shy. I turned her into a monster. 😜",
                "Find someone who brings out the best in you",
                "A best friend is like your favorite bra: supportive, comfortable, hard to find, and close to your heart",
                "A best friend will love you when you’re too sad to love yourself",
                "Yes or No?",
                "How can I help you?",
                "What do you think of this?",
                "How gorgeous is this?",
                "If you could be doing anything right now, what would it be?",
                "Which [fill in the blank] are you?",
                "Trivia Time: How many people have tried [fill in the blank]?",
                "How are you guys doing?",
                "Miss me?",
                "What time is it?",
                "Don’t trust everything you see, even salt can look like sugar",
                "Everyone has a chapter they don’t read out loud",
                "Too lit to quit",
                "Shoutout to myself because I’m lit",
                "I don’t tell you I love you out of habit but as a reminder of how much you mean to me",
                "When I started counting my blessings, I realized I have everything I could ever need",
                "A smile can change the world",
                "The biggest mistake you can ever make is to be afraid to make mistakes",
                "Life is tough but so am I",
                "“My coach said I run like a girl. So I said if he ran a little faster he could too.” – Mia Hamm",
                "Oops is always better than what if",
                "If you want opportunity to knock, it’s time to build a door",
                "The little things in life matter",
                "If you don’t believe in yourself, who will?",
                "I may not be there yet, but I’m closer than I was yesterday",
                "It always seems impossible until it’s done",
                "It may be stormy now but it never rains forever",
                "“There’s a dream that I’ve been chasing want so badly for it to be reality” – Justin Bieber",
                "Dreams don’t have expiration dates, keep going.",
                "Set goals you don’t tell anyone about. Achieve them. Then give yourself the highest of fives!"
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        copyButton= findViewById(R.id.copyBut);
        txtView= findViewById(R.id.captionTxt);
        txtView.setText(generateCaption());


        // TO Copy the captions
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard =(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                String string= txtView.getText().toString();
                ClipData clip =ClipData.newPlainText("Copied Text",string);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show();
            }
        });

    }
    //To Generate a Random String
    public String generateCaption()
    {
        String randomStr =string[new Random().nextInt(string.length)];
        return randomStr;

    }


}
