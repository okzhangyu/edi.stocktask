package org.edi.stocktask.dto;

/**
 * @author Fancy
 * @date 2018/8/20
 */
public interface IDocumentSyncResult {

    String getCode();

    void setCode(String code);

    String getUniquekey();

    void setUniquekey(String uniquekey);

    String getMessage();

    void setMessage(String message);

    String getReturnEntry();

    void setReturnEntry(String returnEntry);
}
