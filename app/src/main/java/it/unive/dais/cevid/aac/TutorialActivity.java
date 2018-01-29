package it.unive.dais.cevid.aac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by Angelko on 1/29/2018.
 */

public class TutorialActivity extends AppCompatActivity {

    int imageNo[] = {R.drawable.first_page, R.drawable.second_page, R.drawable.pie_chart, R.drawable.bar_chart};
    int countImage = imageNo.length;
    int currentImage = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        //button and image switcher
        Button next = (Button) findViewById(R.id.button1);
        Button back = (Button) findViewById(R.id.button2);
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                //Adding ImageView Dinamically
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageNo[currentImage]);
        next.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        currentImage++;
                                        if(currentImage==countImage)
                                            currentImage--;
                                        imageSwitcher.setImageResource(imageNo[currentImage]);
                                    }
                                }

        );
        back.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {
                                        currentImage--;
                                        if(currentImage==-1)
                                            currentImage++;
                                        imageSwitcher.setImageResource(imageNo[currentImage]);
                                    }


                                }

        );

    }
}
