def call(Map stageParams) {

        
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
         
    ])
     node {
      //  git url: "https://github.com/werne2j/sample-nodejs"

        stage("Compile") {
            echo "mvn compile"
        }

        stage("Test") {
            echo "mvn test"
        }

 
    }
  }
