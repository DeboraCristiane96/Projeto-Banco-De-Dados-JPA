
package com.projetoAcademia.com.projetoAcadenia.Entidade;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author debora
 */
enum Profissao {
    
    PREPARADOR_FISICO("Preparador F�sico"),
    COORDENADOR_MUSCULACAO("Coordenador de Muscula��o"),
    COORDENADOR_LUTA("Coordenador de Luta"), 
    COORDENADOR_AQUATICO("Coordenador Aqu�tico");
    private String valor;

   private static final Map<String,Profissao>pegarProf = new HashMap<>();
        
    static {
            for(Profissao prof: Profissao.values()){
                pegarProf.put(prof.getValor(),prof);
            }
    }
    public static Profissao pegarProfissao(String valor){
        return pegarProf.get(valor);
    }
    
     Profissao(String valor){
       this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
   

}
