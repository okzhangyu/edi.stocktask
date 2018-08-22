package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/20
 */
public class DocumentSyncResult implements IDocumentSyncResult{
    private String code;

    @Override
    public String getCode(){return code;}

    @Override
    public void setCode(String code){this.code = code;}

    private String uniquekey;

    @Override
    public String getUniquekey(){return uniquekey;}

    @Override
    public void setUniquekey(String uniquekey){
        this.uniquekey = uniquekey;
    }

    private String message;

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public void setMessage(String message){
        this.message = message;
    }

    private String returnEntry;

    @Override
    public String getReturnEntry(){return returnEntry;}

    @Override
    public void setReturnEntry(String returnEntry){
        this.returnEntry = returnEntry;
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", uniquekey:'" + uniquekey + '\'' +
                ", message:'" + message + '\'' +
                ", returnEntry:'" + returnEntry + '\'' +
                '}';
    }
}
