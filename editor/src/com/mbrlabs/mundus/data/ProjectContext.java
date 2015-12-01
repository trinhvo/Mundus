package com.mbrlabs.mundus.data;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.mbrlabs.mundus.data.home.ProjectRef;
import com.mbrlabs.mundus.terrain.Terrain;

/**
 * @author Marcus Brummer
 * @version 28-11-2015
 */
public class ProjectContext implements Disposable {

    private ProjectRef ref;

    public Environment environment = new Environment();
    public Array<ModelInstance> entities;
    public Array<Model> models;
    public PointLight light;

    public Array<Terrain> terrains;

    public ProjectContext() {
        entities = new Array<>();
        models = new Array<>();
        terrains = new Array<>();

        light = new PointLight();
        light.setPosition(0,50,-10);
        light.setIntensity(1);
        environment.add(light);
    }

    public ProjectRef getRef() {
        return ref;
    }

    public void setRef(ProjectRef ref) {
        this.ref = ref;
    }

    @Override
    public void dispose() {
        for(Model model : models) {
            model.dispose();
        }
        models = null;
    }

}
