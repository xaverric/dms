package cz.uhk.fim.api.rest.controller;

public interface Router {

    /**
     *
     * @return index ThymeLeaf template
     */
    String getHomeScreen();

    /**
     *
     * @return
     */
    String getLoginScreen();

    String getUserScreen();

    String getMainScreen();
}
