package it.unive.dais.cevid.aac;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.coreutils.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


/**
 * Activity per la schermata di crediti e about.
 *
 * @author Alvise Spanò, Università Ca' Foscari
 */
public class InfoActivity extends AppCompatActivity {

    /**
     * Produce la stringa completa coi crediti.
     * @return ritorna la stringa completa.
     */
    public static String credits(Context ctx) {
        ApplicationInfo ai = ctx.getApplicationInfo();
        StringBuffer buf = new StringBuffer();
        buf.append("\tDiego Donaggio").append(" Mat.853837");
        buf.append("\n\tIgnazio Carbonaro").append(" Mat.855503");
        buf.append("\n\tAngelko Fericean").append(" Mat.995851");
        buf.append("\n\tRodica Maria Tecu").append(" Mat.995845");
        buf.append("\n\n\t Description of the App");
        buf.append("\n\n\tOur application helps people get more awareness about how money gets spent in the health sector in Italy.\n" +
                "The application has a map geo-referenced scheme showing information for each region’s health spending. It will provide transparency for users.\n" +
                "More specifically, the app will provide the following information:\n" +
                "How much money the State sends to each Region. It will show a statistic of incoming funds and population (per capita);\n" +
                "Balance between the funds received by each Region from the State and how much money each Region spends in the health sector;\n" +
                "How much money each Region sends to other Regions and how much money it gets from the other Regions for health services;\n" +
                "A coloured map of Italy based on this statistics of incoming money and expenditures.\n");
        return String.format(
                "--- Salute Transparente APP ---\n" +
                        "ver. 1.0.0\n\n" +
                        "--- Our Team ---\n%s",
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
