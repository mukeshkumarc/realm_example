package com.example.mukesh_kumar.realm.Binders;

import com.example.mukesh_kumar.realm.ViewModels.ClassDetailVM;
import com.example.mukesh_kumar.realm.ViewModels.ClassSummaryVM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class ClassSessionDetailsViewBInder {

    public static ClassDetailVM getClassDetailsVMById(Realm realm, int id){
        RealmResults<ClassDetailVM> classDetailVMs=realm.where(ClassDetailVM.class).equalTo("sessionId", id).findAll();
         return  classDetailVMs.get(0);
    }

    public static ClassSummaryVM getClassSummaryVMById(Realm realm, int id){
        RealmResults<ClassDetailVM> classDetailVMs=realm.where(ClassDetailVM.class)
                .equalTo("sessionId", id).findAll();
        return getClassSummaryVMFromClassDetailVM(classDetailVMs).get(0);
    }

    public static List<ClassSummaryVM> getClassSummaryVMListByStudioID(Realm realm,int StudioId ){
        RealmResults<ClassDetailVM> classDetailVMs=realm.where(ClassDetailVM.class)
                .equalTo("StudioId", StudioId).findAll();
        return getClassSummaryVMFromClassDetailVM(classDetailVMs);
    }

    public static List<ClassSummaryVM> getClassSummaryVMListByTrainer(Realm realm,int trainerId){
        RealmResults<ClassDetailVM> classDetailVMs=realm.where(ClassDetailVM.class)
                .equalTo("trainerId", trainerId).findAll();
        return getClassSummaryVMFromClassDetailVM(classDetailVMs);
    }

    public static List<ClassSummaryVM> getClassSummaryVMListByLocality(Realm realm,int localityId,Date date){
        RealmResults<ClassDetailVM> classDetailVMs=realm.where(ClassDetailVM.class)
                .equalTo("localityId", localityId)
                .equalTo("Start_Time",date)
                .findAll();
        return getClassSummaryVMFromClassDetailVM(classDetailVMs);
    }


    public static List<ClassSummaryVM> getClassSummaryVMListByFilter(Realm realm,int selectedDateDay,int localityId,
                                                              int startTimeHour,int endTimeHour,Set<Integer> activityIdSet,
                                                              Set<Integer> amenityIdSet){
        long millis =System.currentTimeMillis()-System.currentTimeMillis()%24*60*60*1000;
        millis=millis*(selectedDateDay+1);
        long startTimeinmillis=millis+startTimeHour*60*60*1000;
        long endtTimeinmillis=millis+endTimeHour*60*60*1000;
        Date Start_Time=new Date(startTimeinmillis);
        Date endTime=new Date(endtTimeinmillis);
        RealmQuery<ClassDetailVM> query = realm.where(ClassDetailVM.class);
        query.equalTo("localityId",localityId).greaterThanOrEqualTo("Start_Time",Start_Time)
                .lessThanOrEqualTo("endTime",endTime);
        query.beginGroup();
        for (Integer activityId  : activityIdSet){
           query.or().equalTo("ActivityVM.id",activityId);
        }
        query.endGroup();
        query.beginGroup();
        for(Integer amenityId : activityIdSet ){
            query.equalTo("ActivityVM.id",amenityId);
        }
        query.endGroup();
        RealmResults<ClassDetailVM> classDetailVMs=query.findAll();
        return getClassSummaryVMFromClassDetailVM(classDetailVMs);
    }



    private static List<ClassSummaryVM> getClassSummaryVMFromClassDetailVM(List<ClassDetailVM> classDetailVMs){
        List<ClassSummaryVM> classSummaryVMs=new ArrayList<>();
        ClassDetailVM classDetailVM;
        ClassSummaryVM classSummaryVM=new ClassSummaryVM();
        for(int i=0;i<classDetailVMs.size();i++){
            classDetailVM=classDetailVMs.get(i);
            classSummaryVM.setId(classDetailVM.getClassId());
            classSummaryVM.setClass_Name(classDetailVM.getClass_Name());
            classSummaryVM.setBackground_ImageURL(classDetailVM.getBackground_Image_URL());
            classSummaryVM.setEndTime(classDetailVM.getEndTime());
            classSummaryVM.setEndTime(classDetailVM.getEndTime());
            classSummaryVM.setLocality(classDetailVM.getLocality());
            classSummaryVM.setStudio_Name(classDetailVM.getStudio_Name());
            classSummaryVM.setTrainer_Name(classDetailVM.getTrainer_Name());
            classSummaryVM.setVideo_URL(classDetailVM.getVideo_URL());
            classSummaryVMs.add(classSummaryVM);
        }

        return  classSummaryVMs;
    }
}
