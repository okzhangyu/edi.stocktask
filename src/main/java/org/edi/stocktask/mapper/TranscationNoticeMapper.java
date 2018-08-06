package org.edi.stocktask.mapper;

import org.edi.freamwork.transcation.TranscationParam;
import org.edi.freamwork.transcation.TranscationResult;

import java.util.HashMap;

public interface TranscationNoticeMapper {

    TranscationResult callTranscationNotice(HashMap<String,String> para);
}
