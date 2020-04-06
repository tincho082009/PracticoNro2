package com.example.practiconro2;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> resultado;
    private MutableLiveData<Boolean> dolaresEuros;
    private MutableLiveData<Boolean> eurosDolares;
    private MutableLiveData<Boolean> textoEuros;
    private MutableLiveData<Boolean> textoDolares;
    private MutableLiveData<String> cartel;


    public LiveData<String> getResultado(){
        if(resultado==null){
            resultado =  new MutableLiveData<String>();
        }
        return resultado;
    }
    public LiveData<Boolean> getDolaresEuros(){
        if(dolaresEuros==null){
            dolaresEuros =  new MutableLiveData<Boolean>();
        }
        return dolaresEuros;
    }
    public LiveData<Boolean> getEurosDolares(){
        if(eurosDolares==null){
            eurosDolares = new MutableLiveData<Boolean>();
        }
        return eurosDolares;
    }
    public LiveData<Boolean> getTextoDolares(){
        if(textoDolares==null){
            textoDolares = new MutableLiveData<Boolean>();
        }
        return textoDolares;
    }
    public LiveData<Boolean> getTextoEuros(){
        if(textoEuros==null){
            textoEuros = new MutableLiveData<Boolean>();
        }
        return textoEuros;
    }
    public LiveData<String> getCartel(){
        if(cartel==null){
            cartel =  new MutableLiveData<String>();
        }
        return cartel;
    }
    public void cambiarEstadoDolaresEuros(){
        dolaresEuros.setValue(false);
        eurosDolares.setValue(true);
    }
    public void cambiarEstadoEurosDolares(){
        eurosDolares.setValue(false);
        dolaresEuros.setValue(true);
    }
    public void cambiarEstadoTextoDolares(){
        textoEuros.setValue(true);
        textoDolares.setValue(false);
    }
    public void cambiarEstadoTextoEuros(){
        textoEuros.setValue(false);
        textoDolares.setValue(true);
    }
    public void conversion(String dolares, String euros){
        try{
            if(textoDolares.getValue() && dolaresEuros.getValue()){
                double dolares1, res = 0;
                dolares1 = Double.parseDouble(dolares);
                res = dolares1 * 0.925272;
                resultado.setValue(res + "");
                cartel.setValue("Conversion exitosa!!");
            }else if(textoEuros.getValue() && eurosDolares.getValue()){
                double euros1, res = 0;
                euros1 = Double.parseDouble(euros);
                res = euros1 * 1.08076;
                resultado.setValue(res + "");
                cartel.setValue("Conversion exitosa!!");
            }
        }catch(NumberFormatException nf ){
            cartel.setValue("ERROR. Solo se permiten numeros");
        }
    }
}
