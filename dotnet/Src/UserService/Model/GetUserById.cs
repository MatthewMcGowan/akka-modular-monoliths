namespace UserService.Model
{
    public class GetUserById
    {
        public GetUserById(int id)
        {
            Id = id;
        }

        public int Id { get; }
    }
}
