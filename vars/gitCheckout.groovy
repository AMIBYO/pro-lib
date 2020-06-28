def call(Map stageParams) {
stage("Install") {
            echo "mvn compile"
        }
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
         
    ])
     node {
      //  git url: "https://github.com/werne2j/sample-nodejs"

        stage("Install") {
            echo "mvn compile"
        }

        stage("Test") {
            sh "mvn package"
        }

 
    }
  }
