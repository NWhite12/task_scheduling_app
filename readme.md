# To-Do List app

## About / Synopsis
This project will be a simple 'todo' list app. Meaning a user can add ideas/projects into the system to be kept track of for them to complete at a later date. The database portion of this app, will be hosted on Amazon Web Service(AWS). The GUI portion of this app, will be handled by the tornadoFX library.  

* To-Do list app
* Kotlin, TornadoFX, AWS
* Project status: Prototype
* Programming Language Final

## Table of contents

> * [To-Do List app](#To-Do-List-app)
>   * [About / Synopsis](#about--synopsis)
>   * [Table of contents](#table-of-contents)
>   * [Requirements](#Requirements)
>   * [Installation](#installation)
>   * [Usage](#usage)
>     * [Screenshots](#screenshots)
>     * [Features](#features)
>   * [Code](#code)
>     * [Content](#content)
>     * [Requirements](#requirements)
>     * [Limitations](#limitations)
>     * [Build](#build)
>     * [Deploy (how to install build product)](#deploy-how-to-install-build-product)
>   * [Resources (Documentation and other links)](#resources-documentation-and-other-links)
>   * [Contributing / Reporting issues](#contributing--reporting-issues)
>   * [License](#license)
>   * [About Nuxeo](#about-nuxeo)

## Requirements
The following are a list of technology's and knowledge that will be referenced during the development of this software. 

- [Kotlin](https://kotlinlang.org/)
    - The programming language that handles the logic of the app
- [jdk 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
    - The run time environment that executes the app. **Note:** jdk 8 is needed because of the tornado fx library needing of java FX which supports jdk 8.
- [TornadoFX](https://tornadofx.io/)
    - The GUI library in which the GUI is made from
- [hybernate](https://hibernate.org/)
    - A tool that map's our java class models into models for the DBMS
- [Maven](https://maven.apache.org/)
    - The Tool that builds the app and makes sure all the dependence's are there. 
- [PG admin](https://www.pgadmin.org/)
    - This allows you to view the database outside of the app to make sure data is save/read correctly. 

## Installation

### Recommendations
We suggest using the windows 10 environment to run/ build this app. We also suggest using the Intellij IDE, as it makes dealing with the multiple technologies much easer. 

**Note:** The app has not been tested on older versions of windows or any Unix based system. So we do not grantee it will work. 

## Usage

### Screenshots

### Features

## Code

[![Build Status](https://qa.nuxeo.org/jenkins/buildStatus/icon?job=/nuxeo/addons_nuxeo-sample-project-master)](https://qa.nuxeo.org/jenkins/job/nuxeo/job/addons_nuxeo-sample-project-master/)

### Content

Description, sub-modules organization...

### Requirements

See [CORG/Compiling Nuxeo from sources](http://doc.nuxeo.com/x/xION)

Sample: <https://github.com/nuxeo/nuxeo/blob/master/nuxeo-distribution/README.md>

### Limitations

Sample: <https://github.com/nuxeo-archives/nuxeo-features/tree/master/nuxeo-elasticsearch>

### Build

    mvn clean install

Build options:

* ...

### Deploy (how to install build product)

Direct to MP package if any. Otherwise provide steps to deploy on Nuxeo Platform:

 > Copy the built artifacts into `$NUXEO_HOME/templates/custom/bundles/` and activate the `custom` template.

## Resources (Documentation and other links)

## Contributing / Reporting issues

Link to JIRA component (or project if there is no component for that project). Samples:

* [Link to component](https://jira.nuxeo.com/issues/?jql=project%20%3D%20NXP%20AND%20component%20%3D%20Elasticsearch%20AND%20Status%20!%3D%20%22Resolved%22%20ORDER%20BY%20updated%20DESC%2C%20priority%20DESC%2C%20created%20ASC)
* [Link to project](https://jira.nuxeo.com/secure/CreateIssue!default.jspa?project=NXP)

## License

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

## About Nuxeo

Nuxeo Content Platform is an open source Enterprise Content Management platform, written in Java. Data can be stored in both SQL & NoSQL databases.

The development of the Nuxeo Content Platform is mostly done by Nuxeo employees with an open development model.

The source code, documentation, roadmap, issue tracker, testing, benchmarks are all public.

Typically, Nuxeo users build different types of information management solutions for [document management](https://www.nuxeo.com/products/document-management/), [case management](https://www.nuxeo.com/products/case-management/), and [digital asset management](https://www.nuxeo.com/products/digital-asset-management/), use cases. It uses schema-flexible metadata & content models that allows content to be repurposed to fulfill future use cases.

More information is available at [www.nuxeo.com](http://www.nuxeo.com)./