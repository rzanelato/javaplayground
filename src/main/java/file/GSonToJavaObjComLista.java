package file;

import java.util.ArrayList;

import com.google.gson.Gson;

import pojo.JSonPojo;
import pojo.PojoConListaJSon;

public class GSonToJavaObjComLista {

	public static void main(String[] args) {
		String jsonString = "{\"codigo\":\"200\", \"descripcion\":\"Sin Error\", \"listaJson\":[{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"abr 19, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"2\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"8000\",\"identificador\":\"80004133\",\"promocion\":\"08000598\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"8000\",\"identificador\":\"80003291\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"9001\",\"identificador\":\"90100372\",\"cartel\":\"24\",\"fechaColocacion\":\"feb 20, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73025789\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"8000\",\"identificador\":\"80003945\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 19, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 19, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 18, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 24, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 25, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73028740\",\"cartel\":\"24\",\"fechaColocacion\":\"sep 14, 2012\",\"usuario\":\"admin\"},{\"sociedad\":\"0731\",\"identificador\":\"73025789\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 18, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"24\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"8000\",\"identificador\":\"80001380\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73025789\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"tipologiaKO\":\"1\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"userDoc\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 26, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"8000\",\"identificador\":\"80002226\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"abr 19, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"8000\",\"identificador\":\"80004487\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"8000\",\"identificador\":\"80003879\",\"promocion\":\"08000732\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73025789\",\"cartel\":\"24\",\"tipologiaKO\":\"1\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0106\",\"identificador\":\"60048316\",\"cartel\":\"24\",\"fechaColocacion\":\"ago 6, 2015\",\"usuario\":\"admin\"},{\"sociedad\":\"9001\",\"identificador\":\"90100465\",\"cartel\":\"24\",\"fechaColocacion\":\"feb 20, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"8000\",\"identificador\":\"80003096\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"abr 17, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 24, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 19, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0001\",\"identificador\":\"00188097\",\"promocion\":\"10105649\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_A\",\"tipologiaKO\":\"1\",\"fechaColocacion\":\"may 3, 2018\",\"usuario\":\"admin\"},{\"sociedad\":\"9001\",\"identificador\":\"90100372\",\"cartel\":\"24\",\"fechaColocacion\":\"feb 20, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"9999\",\"identificador\":\"60189352\",\"cartel\":\"24\",\"fechaColocacion\":\"dic 19, 2016\",\"usuario\":\"admin\"},{\"sociedad\":\"0731\",\"identificador\":\"73025789\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"60084025\",\"cartel\":\"24\",\"fechaColocacion\":\"feb 20, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 18, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 23, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 20, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"abr 18, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 15, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"2\",\"fechaColocacion\":\"abr 19, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"24\",\"fechaColocacion\":\"abr 26, 2018\",\"usuario\":\"userDoc\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"tipologiaKO\":\"1\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"userDoc\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"tipoCarteleria\":\"AE_EV_D\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"8000\",\"identificador\":\"80004133\",\"promocion\":\"08000598\",\"cartel\":\"24\",\"fechaColocacion\":\"mar 8, 2013\",\"usuario\":\"BATCH_CM_EXTERNAL\"},{\"sociedad\":\"0731\",\"identificador\":\"73025789\",\"cartel\":\"24\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 8, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73032380\",\"cartel\":\"24\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 9, 2018\",\"usuario\":\"TesteJUnit\"},{\"sociedad\":\"0731\",\"identificador\":\"73025893\",\"cartel\":\"25\",\"tipologiaKO\":\"3\",\"fechaColocacion\":\"may 14, 2018\",\"usuario\":\"TesteJUnit\"}]}"; 
		jsonString = "{\"codigo\":\"204\", \"descripcion\":\"No hay registros\"}"; 
	
		Gson gson = new Gson();

		PojoConListaJSon listJson = gson.fromJson(jsonString, PojoConListaJSon.class);
			
		int count = 0;
		System.out.println("Codigo: " + listJson.getCodigo() + "\nDescripcion: " + listJson.getDescripcion() + "\n" );
		if (listJson.getListaJson() == null) {
			listJson.setListaJson(new ArrayList<JSonPojo>());
		}
		for (JSonPojo pojo : listJson.getListaJson()) {
			System.out.println(pojo);
			count++;
		}
		
		System.out.println("Count: " + count);
	}

}