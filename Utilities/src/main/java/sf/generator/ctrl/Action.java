/*
 */
package sf.generator.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSon equivalent { "name":"a", "viewUrl":"u/r/l", "params" : ["p1","p2"],
 * "arrayReturn":{"m1": "a", "m2": "b"}
 *
 * }
 *
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

    public String toPHP() {
        String str = "";
        String strParams = "";
        for (String p : params) {
            strParams +=  "$"+p+",";
        }
        strParams=strParams.substring(0, strParams.length() - 1);//spprimer derniere virgule
        String arrResStr = "";
        for (Map.Entry<String, String> entry : arrayReturn.entrySet()) {
            arrResStr += "'"+ entry.getKey() + "' =>$" + entry.getValue() + ",\n";
        }
        str += "public function "+ name+"(" + strParams + "){ \n"
                + "$em=$this->getDoctrine()->getManager(); \n"
                + "return $this->render('" + viewUrl + "', array(" + arrResStr + ")\n);"
                + "\n}";
        return str;
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
