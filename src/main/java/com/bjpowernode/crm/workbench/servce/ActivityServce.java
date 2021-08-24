package com.bjpowernode.crm.workbench.servce;

import com.bjpowernode.crm.vo.PaginationVO;
import com.bjpowernode.crm.workbench.entity.Activity;

import java.util.HashMap;

public interface  ActivityServce {

    boolean save(Activity activity);

    PaginationVO pageList(HashMap<String, Object> hashMap);

    boolean deleteInfo(String[] ids);
}
