pipeline {
    agent any
    
    triggers {
        pollSCM('* * * * *')
    }
    
    stages {
        stage ("Checkout") {
            steps {
                git url: 'https://github.com/edineva20/calculator2.git'
            }
        }
        
        stage ("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        
        stage ("Unit test") {
            steps {
                sh "./gradlew test"
            }
        }
        stage("Code coverage") {
           steps {
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: "JaCoCo Report"
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        
        stage ("Package") {
           steps {
               sh "./gradlew build"
           }
        }
        
        stage ("Docker build") {
            steps {
                sh "docker build -t calculator2 ."
            }
        }
        
        stage ("Docker tag") {
            steps {
                sh "docker tag calculator2 myregistrydomain.com/calculator2:1 "
            }
        }
        
        stage ("Docker push") {
            steps {
                sh "docker push myregistrydomain.com/calculator2:1"
            }
        }
        
        stage ("Deploy to staging") {
            steps {
             // sh "docker run -d --rm -p 8765:8080 --name calculator2 myregistrydomain.com/calculator2:1"
             echo hostname
            }
        }
        
        stage ("Acceptance Test") {
            steps {
                sleep 5 
                sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
                
            }
        }
    }
    
/*   post {
      always {
            mail to: 'elena_m@yahoo.com',
            subject: "Completed pipeline: ${currentBuild.fullDisplayName}",
            body: "your build completed. Please check: ${env.BUILD_URL}"
        }
    } */
    
    post {
        always {
           // sh "docker stop calculator2"
           echo "Post stage"
        }
    }

}
