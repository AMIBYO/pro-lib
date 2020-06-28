def call(Map stageParams) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
         sh "mvn compile"
    ])
     node {
      //  git url: "https://github.com/werne2j/sample-nodejs"

        stage("Install") {
            sh "mvn compile"
        }

        stage("Test") {
            sh "mvn package"
        }

 
    }
  }
