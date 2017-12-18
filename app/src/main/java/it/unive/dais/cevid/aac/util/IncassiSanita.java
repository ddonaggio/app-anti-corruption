package it.unive.dais.cevid.aac.util;

import android.content.Context;
import android.os.AsyncTask;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import it.unive.dais.cevid.aac.R;
import it.unive.dais.cevid.datadroid.lib.parser.CsvRowParser;
import it.unive.dais.cevid.datadroid.lib.parser.AsyncParser;

/**
 * Created by ddonaggio on 18/12/17.
 */

public class IncassiSanita {

    private List<DataRegione> incassiSanitaData;

    public IncassiSanita(List<IncassiSanita.DataRegione> incassiSanitaData) {
        this.incassiSanitaData = incassiSanitaData;
    }


    // data struc for each csv row
    public static class DataRegione {
        private String id;
        private String nomeRegione;
        private String titolo;
        private String codice;
        private String descrizione;
        private Double importo;

        public DataRegione(String id, String nomeRegione, String titolo, String codice, String descrizione, Double importo) {
            this.id = id;
            this.nomeRegione = nomeRegione;
            this.titolo = titolo;
            this.codice = codice;
            this.descrizione = descrizione;
            this.importo = importo;
        }

        public String getId() {
            return id;
        }

        public String getNomeRegione() {
            return nomeRegione;
        }

        public String getTitolo() {
            return titolo;
        }

        public String getCodice() {
            return codice;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public Double getImporto() {
            return importo;
        }
    }
    
    public List<IncassiSanita.DataRegione> getDataByIdRegione(String IdRegione) {
        List<IncassiSanita.DataRegione> temp = new ArrayList<>();
        for (DataRegione dr : incassiSanitaData) {
            if (dr.getId().equals(IdRegione)) {
                temp.add(dr);
            }
        }
        return temp;
    }

    public Map<String,Double> getImportiByIdRegione(String IdRegione) {
        Map<String, Double> temp = new HashMap<>();
        for (DataRegione dr : getDataByIdRegione(IdRegione)) {
            if(temp.containsKey(dr.getTitolo())) {
                temp.put(dr.getTitolo(), temp.get(dr.getTitolo()) + dr.getImporto());
            } else {
                temp.put(dr.getTitolo(), dr.getImporto());
            }
        }
        return temp;
    }

    /**
     * Converts a HashMap.toString() back to a HashMap
     * @param text
     * @return HashMap<String, String>
     */
    public static HashMap<String,Double> convertToStringToHashMap(String text){
        HashMap<String,Double> data = new HashMap<String,Double>();
        Pattern p = Pattern.compile("[\\{\\}\\=\\, ]++");
        String[] split = p.split(text);
        for ( int i=1; i+2 <= split.length; i+=2 ){
            data.put( split[i], Double.parseDouble(split[i+1]) );
        }
        return data;
    }
}

