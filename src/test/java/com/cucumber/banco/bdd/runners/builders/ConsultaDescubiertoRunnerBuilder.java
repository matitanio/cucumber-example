package com.cucumber.banco.bdd.runners.builders;

import com.cucumber.banco.bdd.runners.ConsultaDescubiertoRunner;
import com.cucumber.banco.bdd.runners.api.ConsultaDescubiertoApiRunner;
import com.cucumber.banco.bdd.runners.backendRunnner.ConsultaDescubiertoBackendRunner;

import java.util.HashMap;
import java.util.Map;

public class ConsultaDescubiertoRunnerBuilder {

    private Map<ConsultaDescubiertoRunnerBuilders, ConsultaDescubiertoRunner> runners = new HashMap<>();
    private  static ConsultaDescubiertoRunnerBuilder instance;

    private ConsultaDescubiertoRunnerBuilder(){

        runners.put(ConsultaDescubiertoRunnerBuilders.API, new ConsultaDescubiertoApiRunner());
        runners.put(ConsultaDescubiertoRunnerBuilders.BACK_END, new ConsultaDescubiertoBackendRunner());
    }

    public enum ConsultaDescubiertoRunnerBuilders{
        API, BACK_END
    }

    public static ConsultaDescubiertoRunnerBuilder getInstance(){

        if(instance == null){
            instance = new ConsultaDescubiertoRunnerBuilder();
        }

        return instance;
    }


    public ConsultaDescubiertoRunner getRunner(ConsultaDescubiertoRunnerBuilders runner){
        return runners.get(runner);
    }

}
