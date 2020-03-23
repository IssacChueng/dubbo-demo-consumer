pipeline {
  agent any
  stages {
    stage('pull') {
        steps {
            echo 'git pull'
        }
    }
    stage('build') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('package') {
      steps {
        sh 'mvn package -DskipTests'
      }
    }

    stage('deploy') {
        steps {
            withEnv(['JENKINS_NODE_COOKIE=dontKillMe']) {
                sh '''
                    export BUILD_ID=dontKillMe
                    echo "关闭consumer"
                    ssh peer2 "cd dubbo-demo/ && sh stop.sh"
                    echo "传输jar"
                    scp target/consumer.jar peer2:dubbo-demo/consumer/
                    ssh peer2 "cd dubbo-demo/ && sh start.sh"
                '''
            }
        }
    }
  }
}