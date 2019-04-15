/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mark_
 */ 
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Create {

    public static void main(String[] args) {

        Configuration conf = new AnnotationConfiguration();
        conf.configure(); //este método é responsável por ler o arquivo hibernate.cfg.xml
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true); //este método imprime o script de criação do banco de dados no console e exporta o banco de dados de acordo com as configurações do arquivo hibernate.cfg.xml

    }
}
