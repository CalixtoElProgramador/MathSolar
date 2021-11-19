package com.listocalixto.android.mathsolar.data.source.pv_project

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.listocalixto.android.mathsolar.core.Resource
import com.listocalixto.android.mathsolar.data.model.PVProject

interface PVProjectDataSource {

    fun observePVProjects(): LiveData<Resource<List<PVProject>>>

    fun observePVProject(projectId: String): LiveData<Resource<PVProject>>

    suspend fun getPVProjects(): Resource<List<PVProject>>

    suspend fun getPVProject(projectId: String): Resource<PVProject>

    suspend fun refreshPVProjects()

    suspend fun refreshPVProject(projectId: String)

    suspend fun savePVProject(imageBitmap: Bitmap?, project: PVProject)

    suspend fun likePVProject(project: PVProject)

    suspend fun likePVProject(projectId: String)

    suspend fun dislikePVProject(project: PVProject)

    suspend fun dislikePVProject(projectId: String)

    suspend fun deleteAllPVProjects()

    suspend fun deletePVProject(projectId: String)

}