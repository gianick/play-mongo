package services

import models.User
import play.api.libs.json.JsValue

import scala.concurrent.Future

trait UserService {
  def findUser(id: Long): Future[Option[User]]

  def findAllUsers(): Future[List[User]]

  def insertUser(user: User): Future[Option[User]]

  def removeUser(id: Long): Future[Boolean]

  def updateUser(id: Long, update: JsValue): Future[User]
}
