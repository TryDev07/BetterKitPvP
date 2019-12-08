package nl.trydev07.betterkitpvp.utilitys.filemanager;

/* TryDev07 created on 12/7/2019
 * Project:  Defaults
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface InterfaceYmlFile {
    void create(String filename, boolean getResourceFromFile);
    void load();
    void save();
    void set(String path, Object s);
}
