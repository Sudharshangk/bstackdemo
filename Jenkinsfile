pipeline {
    agent any

    environment {
        APP_ENV = 'dev'
    }

    stages {
        stage('Clone') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: 'https://github.com/Sudharshangk/bstackdemo.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building the project and running TestNG tests with Maven...'
 
                bat 'mvn clean test'
            }pipeline {
    agent any

    environment {
        APP_ENV = 'dev'
        GIT_BRANCH = 'main'
        GIT_URL = 'https://github.com/Sudharshangk/bstackdemo.git'
        GIT_CREDENTIALS_ID = 'github-credentials'   // create this in Jenkins
    }

    stages {
        stage('Clone') {
            steps {
                echo 'Cloning repository...'
                git branch: "${env.GIT_BRANCH}", url: "${env.GIT_URL}", credentialsId: "${env.GIT_CREDENTIALS_ID}"
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building the project and running TestNG tests with Maven...'
                bat 'mvn clean test'
            }
        }

        stage('Push Changes') {
            steps {
                echo 'Pushing local changes to GitHub...'
                withCredentials([usernamePassword(credentialsId: 'CapstoneProject', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_TOKEN')]) {
                    bat """
                    git config user.email "sudharshangk7702@gmail.com"
                    git config user.name "admin"

                    git add .
                    git commit -m "Automated commit from Jenkins" || echo "No changes to commit"

                    git push https://${GIT_USER}:${GIT_TOKEN}@github.com/saisai18018/CapstoneProject.git HEAD:main
                    """
                }
            }
        }

        stage('Publish Reports') {
            steps {
                echo 'Publishing ExtentReports in Jenkins...'
                publishHTML([
                    reportDir: 'reports/ExtentReports',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    allowMissing: false,
                    alwaysLinkToLastBuild: true
                ])
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to ${env.APP_ENV} environment..."
            }
        }
    }

    post {
        success {
            echo ' Pipeline succeeded!'
        }
        failure {
            echo ' Pipeline failed! Please check Jenkins logs and ExtentReport.'
        }
    }
}

        }

        stage('Publish Reports') {
            steps {
                echo 'Publishing ExtentReports in Jenkins...'
                publishHTML([
                    reportDir: 'reports/ExtentReports',    
                    reportFiles: 'index.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    allowMissing: false,
                    alwaysLinkToLastBuild: true
                ])
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to ${env.APP_ENV} environment..."
            }
        }
    }

    post {
        success {
            echo ' Pipeline succeeded!'
        }
        failure {
            echo ' Pipeline failed! Please check Jenkins logs and ExtentReport.'
        }
    }
}
