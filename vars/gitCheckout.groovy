def call(Map stageParams) {

        
    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
         
    ])
     node {
        git url:  stageParams.url

        stage("Compile") {
            bat "mvn compile"
        }

        stage("Test") {
            echo "mvn test"
        }

 
    }
  }
