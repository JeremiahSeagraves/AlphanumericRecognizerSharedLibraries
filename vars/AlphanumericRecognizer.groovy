def call(Closure body){
    pipeline{
        agent any
        parameters{
            choice(name: 'ACTION', choices: ['CD','CI','Deploy'], description: '' ) 
        }
        environment {
            TMP_DIRGV = "tmpGVersion"
        }
        stages{
            stage('Test'){
                steps{
                    sh "echo test"
                }
            }
        }
        post {
            always {
                dir("${WORKSPACE}"){
                    dir(".."){
                        sh 'rm -rf ${WORKSPACE}*'
                    }
                }
            }
        }
    }
}