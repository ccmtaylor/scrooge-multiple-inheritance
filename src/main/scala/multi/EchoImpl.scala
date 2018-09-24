package multi
import com.twitter.util.{Closable, Future}



class EchoImpl
  extends ExtendedEcho.MethodPerEndpoint
     with Echo.MethodPerEndpoint {

  /** if we don't override `asClosable`, the compiler says:

Error:(6, 7) class FooImpl inherits conflicting members:
  method asClosable in trait ExtendedEcho of type => com.twitter.util.Closable  and
  method asClosable in trait Echo of type => com.twitter.util.Closable
(Note: this can be resolved by declaring an override in class FooImpl.)
class FooImpl extends ExtendedEcho.MethodPerEndpoint with Echo.MethodPerEndpoint {

   */
  override def asClosable: Closable = Closable.all(
    Closable.nop
    // XXX there is no way to delegate to both inherited
    // `.asClosable` methods.
//    super[Echo.MethodPerEndpoint].asClosable,
//    super[ExtendedEcho.MethodPerEndpoint].asClosable
  )

  override def echo(request: EchoRequest): Future[EchoResponse] = ???
  override def somethingElse(request: EchoRequest): Future[EchoResponse] = ???
}
