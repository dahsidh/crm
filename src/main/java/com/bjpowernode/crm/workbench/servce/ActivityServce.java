package com.bjpowernode.crm.workbench.servce;

import com.bjpowernode.crm.vo.PaginationVO;
import com.bjpowernode.crm.workbench.entity.Activity;
import com.bjpowernode.crm.workbench.entity.ActivityRemark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface  ActivityServce {

    boolean save(Activity activity);

    PaginationVO pageList(HashMap<String, Object> hashMap);

    boolean deleteInfo(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(Activity activity);

    Activity getdetail(String id);

    List<ActivityRemark> getRemarkListByAid(String id);

    boolean deleteRemark(String id);

    boolean saveReark(ActivityRemark remark);


    boolean updateRemark(ActivityRemark remark);
}
