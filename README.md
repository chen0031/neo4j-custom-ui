# RD-Switchboard Custom UI Neo4j Repository

This repository contains a binaries, patch and sources for Neo4j 2.2.4 database with Custom UI used in RD-Switchboard project

### Requirements

This Repository has been comiled in Ubuntu Linux 14.04 and will require Linux or Unix system. The neo4j-browser can not be compiled in Windows enviroments.

This Repository will require Java 1.7 and Apache Maven 3.0.5. The neo4j-browser will also require Node.js and npm to be installed locally. 

### Build and Inatall

There is several ways to build and install Neo4j from this repository.

#### Build from sources

To build Neo4j from sources provided in this repository, you can use Maven. You will need to have Maven, Java and Node.Js installed in order to do that.

To build whole repository, execute (from a main repository folder):

```
mvn package
```

To install repository into your local Maven repository,  execute (from a main repository folder):

```
mvn install
```

Please refer to original Neo4j documentation for other installiation options. The documentation can be found in the [Neo4j Git Repository](https://github.com/neo4j/neo4j)


#### Use existing binaries and build only neo4j-browser

The whole repository building could be a long process. To save time, you can build only neo4j-browser library and download rest of the original Neo4j distributive. This distrubutive can be downloaded from the [official Neo4j Web site](http://neo4j.com/artifact.php?name=neo4j-community-2.2.4-unix.tar.gz). For you convinience we have also provded a copy of this distributive in this archive. It is located in `dist/neo4j-community-2.2.4-unix.tar.gz` 

To download and install the original Neo4j 2.2.4 into your home directory, execute:

```
wget http://neo4j.com/artifact.php?name=neo4j-community-2.2.4-unix.tar.gz -O neo4j-community-2.2.4-unix.tar.gz
tar -xzvf neo4j-community-2.2.4-unix.tar.gz
```

You will need to replace `neo4j-community-2.2.4/system/lib/neo4j-browser-2.2.4.jar` with customised version.

To do that, execute (from a main repository folder):

```
mvn package -pl :neo4j-browser -am
```

If comile process will success, compiled libaray will appear in `${main repository folder}/community/browser/target/neo4j-browser-2.2.4-SNAPSHOT.jar` rename it into `neo4j-browser-2.2.4.jar` and compile it into `${Neo4j home}/system/lib/`:

```
cp ${repository.folder}/community/browser/target/neo4j-browser-2.2.4-SNAPSHOT.jar ${neo4j.home}/system/lib/neo4j-browser-2.2.4.jar
```

replace ${repository.folder} with actuall path to your repository and ${neo4j.home} to the actual path to the folder where you have installed Neo4j.


#### Apply a patch to original Neo4j

We have provided a patch file what can be applyed to the original Neo4j repository. The patch can be found in `patchs/rd-switchboard-custom-ui.patch`. To apply it, clone the original Neo4j Repository, copy patch into repository folder and apply:

```
# Clone the repositiry
git clone https://github.com/neo4j/neo4j.git

# switch to the repository folder
cd neo4j

# Switch it to 2.2.4 version
git checkout 2.2.4

# copy patch to the repository folder and check it
git apply --check rd-switchboard-custom-ui.patch

# apply a patch if check does not show any error
git apply --check rd-switchboard-custom-ui.patch

# clean build new repository
mvn clean package
```

Please refer to original Neo4j documentation for other installiation options. The documentation can be found in the [Neo4j Git Repository](https://github.com/neo4j/neo4j)




