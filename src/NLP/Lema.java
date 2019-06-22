package NLP;

import java.util.List;

public class Lema {

    private String concepto;
    private List<String> sinonimos;

    public Lema(String concepto, List<String> sinonimos) {
        this.concepto = concepto;
        this.sinonimos = sinonimos;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public List<String> getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(List<String> sinonimos) {
        this.sinonimos = sinonimos;
    }

    public boolean match(String userInput){

        if(userInput.toLowerCase().contains(concepto.toLowerCase())){
            return true;
        } else {
            for(String sinonimo: sinonimos){
                if(userInput.toLowerCase().contains(sinonimo.toLowerCase())){
                    return true;
                }
            }
        }

        return false;
    }
}
