/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf.generator.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSon equivalent
 *{
   "name":"a",
   "viewUrl":"u/r/l",
   "params" : ["p1","p2"],
   "arrayReturn":{"m1": "a", "m2": "b"}
   
 }
 * @author mohamed
 */
public class Action {

    private String name;
    private String viewUrl;
    private List<String> params;
    private Map<String, String> arrayReturn;

    public Action(String name, String viewUrl, List<String> params) {
        this.name = name;
        this.viewUrl = viewUrl;
        this.params = params;
        this.arrayReturn = new HashMap<>();
    }

    public Action() {

    }

    public void addParam(String p) {
        this.params.add(p);
    }

    public void addReturnValue(String key, String value) {
        this.arrayReturn.put(key, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public Map<String, String> getArrayReturn() {
        return arrayReturn;
    }

    public void setArrayReturn(Map<String, String> arrayReturn) {
        this.arrayReturn = arrayReturn;
    }

}
