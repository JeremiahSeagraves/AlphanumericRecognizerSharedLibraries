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
                when {
                    allOf{
                        expression { return params.ACTION ==~ /(CD|CI)/ }
                    }
                    anyOf{ branch 'master' }
                    steps{
                        echo "Test print"
                    }
                }
            }
        }
    }
}