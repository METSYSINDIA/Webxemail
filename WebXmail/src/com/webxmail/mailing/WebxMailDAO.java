package com.webxmail.mailing;

import java.util.List;
import java.util.Map;

public interface WebxMailDAO {

	List<Map<String, Object>> getCommonConstList(String constType, Object[] obj);

	void insertMailData(WebxMailBean bean);

	List<Map<String, Object>> getMailDetailsList();

	List<Map<String, Object>> getMailDetailsEditList(WebxMailBean bean);

}
