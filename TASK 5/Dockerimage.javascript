stage('Docker Build') {
    steps {
        script {
            def dockerImage = docker.build("sample-application:${env.BUILD_ID}")
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                dockerImage.push()
            }
        }
    }
}
