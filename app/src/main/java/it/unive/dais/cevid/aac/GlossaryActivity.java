package it.unive.dais.cevid.aac;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.coreutils.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Activity per la schermata di crediti e about.
 *
 * @author Alvise Spanò, Università Ca' Foscari
 */
public class GlossaryActivity extends AppCompatActivity {

    /**
     * Produce la stringa completa coi crediti.
     * @return ritorna la stringa completa.
     */
    public static String credits(Context ctx) {
        ApplicationInfo ai = ctx.getApplicationInfo();
        StringBuffer buf = new StringBuffer();
        buf.append("\tRegion=").append(" an area, especially part of a country or the world having definable characteristics but not always fixed boundaries.\n");
        buf.append("\t\n Chart=").append(" a sheet of information in the form of a table, graph, or diagram.\n");
        buf.append("\t\n Pie Chart=").append(" a circular statistical graphic which is divided into slices to illustrate numerical proportion. In a pie chart, the arc length of each slice, is proportional to the quantity it represents.\n");
        buf.append("\t\n Bar Chart=").append("or bar graph is a chart or graph that presents categorical data with rectangular bars with heights or lengths proportional to the values that they represent.\n");
        buf.append("\t\n Logarithmic scale=").append(" a nonlinear scale used when there is a large range of quantities. It is based on orders of magnitude, rather than a standard linear scale, so the value represented by each equidistant mark on the scale is the value at the previous mark multiplied by a constant.\n");
        buf.append("\t\n Android=").append(" an operating system for mobile devices developed by Google.\n");
        buf.append("\t\n Map=").append(" a web mapping service developed by Google. It offers satellite imagery, street maps, 360° panoramic views of streets (Street View), real-time traffic conditions (Google Traffic), and route planning for traveling by foot, car, bicycle (in beta), or public transportation.\n ");

        return String.format(
                "--- Glossary ---\n\n" +
                        "%s",
                buf);
    }

    /**
     * Metodo di creazione dell'activity che imposta il layout e la text view con la stringa con i crediti.
     * @param saveInstanceState
     */
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_info);
        TextView tv_1 = (TextView) findViewById(R.id.textView_1);
        tv_1.setText(credits(this));
    }

}
