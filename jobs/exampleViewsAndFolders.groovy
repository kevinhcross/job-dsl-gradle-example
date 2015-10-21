def nameVar = "khc123"
def jobName = "$nameVar-test-job"
def folderName = "$nameVar-test-folder"
def listViewName = "$nameVar-test-list-view"

folder(folderName) {
    description 'This example shows basic folder/job creation.'
}

job("$folderName/$jobName") {
    steps {
        shell 'uname -a'
    }
}

listView(listViewName) {
    description('This should contain a folder')
    jobs {
        name(folderName)
    }
    columns {
        status()
        weather()
        name()
        buildButton()
        lastSuccess()
        lastFailure()
        lastDuration()
    }
}

