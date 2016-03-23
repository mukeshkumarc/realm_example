package com.example.mukesh_kumar.realm.Binders;

import com.example.mukesh_kumar.realm.ViewModels.TrainerDeatilVM;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by mukesh_kumar on 22/10/15.
 */
public class TrainerDetailViewBinder {

    public TrainerDeatilVM getTrainerVMById(Realm realm,int id){
        RealmResults<TrainerDeatilVM> trainerDeatilVMs=realm.where(TrainerDeatilVM.class).equalTo("id",id).findAll();
        return  trainerDeatilVMs.get(0);
    }

}
