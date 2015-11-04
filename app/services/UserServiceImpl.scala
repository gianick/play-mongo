package services

import java.time.ZonedDateTime
import javax.inject.Inject

import dao.UserDao
import models.User
import play.api.libs.json.{Json, JsObject, JsValue}

import scala.concurrent.Future

class UserServiceImpl @Inject()(userDao: UserDao) extends UserService {

  override def findUser(id: Long): Future[Option[User]] = userDao.findUser(id)

  override def findAllUsers(): Future[List[User]] = userDao.findAllUsers()

  override def insertUser(user: User): Future[Option[User]] = userDao.insertUser(user)

  override def removeUser(id: Long): Future[Boolean] = userDao.removeUser(id)

  override def updateUser(id: Long, update: JsValue): Future[User] = {
    val updateWithUpdatedDate = update.as[JsObject] ++ Json.obj("updatedDate" -> ZonedDateTime.now)
    userDao.updateUser(id, updateWithUpdatedDate)
  }
}

